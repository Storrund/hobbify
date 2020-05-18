import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService, UserService} from '../../service';
import {Subject} from 'rxjs/Subject';
import {takeUntil} from 'rxjs/operators';
import {ProfileService} from '../../service/profile.service';

@Component({
  selector: 'hobbify-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {
  form: FormGroup;

  message = [];

  returnUrl: string;
  private ngUnsubscribe: Subject<void> = new Subject<void>();

  constructor(
    private userService: UserService,
    private authService: AuthService,
    private profileService: ProfileService,
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder
  ) {

  }

  ngOnInit() {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    this.form = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(64)])],
      password: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])]
    });
  }

  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  onResetCredentials() {
    this.userService.resetCredentials()
      .pipe(takeUntil(this.ngUnsubscribe))
      .subscribe(res => {
        if (res.result === 'success') {
          alert('Password has been reset to 123 for all accounts');
        } else {
          alert('Server error');
        }
      });
  }

  onSubmit() {
    this.message = [];

    this.authService.login(this.form.value)
      .subscribe(data => {
          this.userService.getMyInfo().subscribe(user => {
              this.profileService.getProfileByUserUuid(user.uuid).subscribe(profile => {
                  this.profileService.setUserProfile(profile);
                  this.userService.setCurrentUser(user);
                  this.router.navigate([`/${this.returnUrl}`]);
              });
          });
        },
        error => {
          this.message.push( {severity: 'error', summary: 'Incorrect username or password.'} );
        });

  }


}
