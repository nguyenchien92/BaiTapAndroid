package com.example.nguyen.mission1.models;

public class ArticleNews {

    private int imageArticle;
    private String nameSite;
    private String timePost;
    private String commentArticle;
    private String commentLink;
    private int numberLike;
    private int numberShare;
    private int numberComment;
    private int imageUser;
    private int imageIconSite;

    public ArticleNews(int imageArticle,
                       String nameSite, String timePost,
                       String commentArticle, String commentLink,
                       int numberLike, int numberShare, int numberComment,
                       int imageUser,int imageIconSite) {
        this.imageArticle = imageArticle;
        this.nameSite = nameSite;
        this.timePost = timePost;
        this.commentArticle = commentArticle;
        this.commentLink = commentLink;
        this.numberLike = numberLike;
        this.numberShare = numberShare;
        this.numberComment = numberComment;
        this.imageUser = imageUser;
        this.imageIconSite = imageIconSite;
    }
    public ArticleNews(){}

    public int getImageIconSite() {
        return imageIconSite;
    }

    public void setImageIconSite(int imageIconSite) {
        this.imageIconSite = imageIconSite;
    }

    public int getImageArticle() {
        return imageArticle;
    }

    public void setImageArticle(int imageArticle) {
        this.imageArticle = imageArticle;
    }

    public String getNameSite() {
        return nameSite;
    }

    public void setNameSite(String nameSite) {
        this.nameSite = nameSite;
    }

    public String getTimePost() {
        return timePost;
    }

    public void setTimePost(String timePost) {
        this.timePost = timePost;
    }

    public String getCommentArticle() {
        return commentArticle;
    }

    public void setCommentArticle(String commentArticle) {
        this.commentArticle = commentArticle;
    }

    public String getCommentLink() {
        return commentLink;
    }

    public void setCommentLink(String commentLink) {
        this.commentLink = commentLink;
    }

    public int getNumberLike() {
        return numberLike;
    }

    public void setNumberLike(int numberLike) {
        this.numberLike = numberLike;
    }

    public int getNumberShare() {
        return numberShare;
    }

    public void setNumberShare(int numberShare) {
        this.numberShare = numberShare;
    }

    public int getNumberComment() {
        return numberComment;
    }

    public void setNumberComment(int numberComment) {
        this.numberComment = numberComment;
    }

    public int getImageUser() {
        return imageUser;
    }

    public void setImageUser(int imageUser) {
        this.imageUser = imageUser;
    }
}
