import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BlogService } from '../blog.service';
import { CommentService } from '../comment.service';
import { Comments } from '../models/comment';
import { Post } from '../models/post';
import { TokenStorageService } from '../services/token-storage.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-single-blog',
  templateUrl: './single-blog.component.html',
  styleUrls: ['./single-blog.component.css']
})
export class SingleBlogComponent implements OnInit {

  id !: number;
  userId ! :number;
  currentPost : Post = new Post();
  comments !: any;
  newComment : Comments ={
    id : 0 ,
    comment_field : '' ,
    createdAt : Date.now() ,
  }

  constructor(
    private postService: BlogService,
    private route: ActivatedRoute,
    private router: Router,
    private userService : UserService,
    private token : TokenStorageService,
    private commentService : CommentService 
  ) { }

  ngOnInit(): void {
    this.userId =parseInt(this.token.getUser().id) ;
    this.id = this.route.snapshot.params['id'];
    this.comments = this.getCommentsByPubId(this.route.snapshot.params['id']);
    this.postService.get(this.id).subscribe( data=>{
      this.currentPost=data;
    } );

    
    
  } 

  getCommentsByPubId(id : number){
      this.commentService.getByPubId(this.id)
      .subscribe( 
        data => {
          this.comments = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  postComment(){
    
    this.commentService.postComment(this.newComment , this.userId , this.id).subscribe(
      (data)=>{
        console.log(data)
        this.reloadPage();
      },(err)=>{
        console.log(err)
      }
    )
  }

  onSubmit(){
    console.log(this.newComment);
    this.postComment();
  }

  reloadPage(){
    window.location.reload();
  }


}


