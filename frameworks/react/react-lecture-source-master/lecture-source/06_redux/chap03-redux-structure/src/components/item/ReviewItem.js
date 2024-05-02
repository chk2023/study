function ReviewItem ({review}) {

    return (
        <div>
            <h2>제목 : {review.title}</h2>
            <p>작성자 : {review.writer}</p>
            <p>내용 : {review.content}</p>
        </div>
    );
}

export default ReviewItem;