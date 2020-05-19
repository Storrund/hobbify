import {Component, Input, OnInit} from '@angular/core';
import {PostVoModel} from '../../../shared/domain/post-vo.model';

@Component({
    selector: 'hobbify-post',
    templateUrl: './post.component.html',
    styleUrls: ['./post.component.scss']
})
export class PostComponent implements OnInit {

    @Input() post: PostVoModel;

    constructor() {}

    ngOnInit() {
    }
}
