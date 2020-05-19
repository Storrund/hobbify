import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {PostService} from '../../service/post.service';
import {ProfileService} from '../../service/profile.service';
import {HobbyVoModel} from '../../shared/domain/hobby-vo.model';
import {PostDtoModel} from '../../shared/domain/post-dto.model';
import {PostVoModel} from '../../shared/domain/post-vo.model';
import {orderBy} from 'lodash';

@Component({
    selector: 'hobbify-hobby-feed',
    templateUrl: './hobby-feed.component.html',
    styleUrls: ['./hobby-feed.component.scss']
})
export class HobbyFeedComponent implements OnInit {

    _hobby: HobbyVoModel;
    get hobby(): HobbyVoModel {
        return this._hobby;
    }

    @Input('hobby')
    set hobby(hobby: HobbyVoModel) {
        this._hobby = hobby;
        if (hobby) {
            this.loadPosts();
        }
    }

    posts: PostVoModel[] = [];

    content: string;
    postForm: boolean = false;

    constructor(
        private postService: PostService,
        private profileService: ProfileService,
        private router: Router
    ) {
    }

    ngOnInit() {}

    loadPosts() {
        this.profileService.getUserProfile().subscribe(profile => {
            this.postService.getAllByHobbyUuidAndProfileUuid(this.hobby.uuid, profile.uuid, 5, this.posts.length).subscribe(posts => {
                this.posts = [...this.posts, ...posts];
                this.sortPosts();
            });
        });
    }

    onSubmit() {
        if (this.content) {
            const postDto = this.createPostDto();
            this.postService.savePost(postDto).subscribe(post => {
                this.posts.push(post);
                this.sortPosts();
                this.postForm = false;
            });
        }
    }

    onPost() {
        this.postForm = true;
    }

    onEvent() {

    }

    onLoadPosts() {
        this.loadPosts();
    }

    createPostDto() {
        const postDto = new PostDtoModel();
        postDto.content = this.content;
        postDto.hobbyUuid = this.hobby.uuid;
        this.profileService.getUserProfile().subscribe(profile => {
            postDto.profileUuid = profile.uuid;
        });

        return postDto;
    }

    private sortPosts() {
        this.posts = orderBy(this.posts, [function (item) {
            return item.postDate
        }], ['desc']);
    }
}
