import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {PostService} from '../../service/post.service';
import {ProfileService} from '../../service/profile.service';
import {HobbyVoModel} from '../../shared/domain/hobby-vo.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PostDtoModel} from '../../shared/domain/post-dto.model';

@Component({
    selector: 'hobbify-hobby-feed',
    templateUrl: './hobby-feed.component.html',
    styleUrls: ['./hobby-feed.component.scss']
})
export class HobbyFeedComponent implements OnInit {

    @Input() hobby: HobbyVoModel;

    content: string;

    constructor(
        private postService: PostService,
        private profileService: ProfileService,
        private router: Router
    ) {
    }

    ngOnInit() {
    }

    onSubmit() {
        if (this.content) {
            const postDto = this.createPostDto();
            this.postService.savePost(postDto).subscribe();
        }
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
}
