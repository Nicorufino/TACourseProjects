package com.solvd.newsPortal.services;

import com.solvd.newsPortal.classes.comment.Comment;

public interface ICommentService {
    Comment getCommentById(Long id);
}
