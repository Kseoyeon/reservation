package kr.or.connect.reservation.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Comment {
	private int id;
	private int productId;
	private int score;
	private String reservationEmail;
	private String comment;
	private Date createDate;
	private Date modifyDate;
	private String reservationUserCommentImages;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getReservationEmail() {
		return reservationEmail;
	}
	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getReservationUserCommentImages() {
		return reservationUserCommentImages;
	}
	public void setReservationUserCommentImages(String reservationUserCommentImages) {
		this.reservationUserCommentImages = reservationUserCommentImages;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", productId=" + productId + ", score=" + score + ", reservationEmail="
				+ reservationEmail + ", comment=" + comment + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + ", reservationUserCommentImages=" + reservationUserCommentImages + "]";
	}
}
