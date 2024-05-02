import {useDispatch, useSelector} from "react-redux";
import {useEffect} from "react";
import ReviewItem from "../item/ReviewItem";
import {callGetReviewListAPI} from "../../api/ReviewAPICalls";
function ReviewList () {

    const dispatch = useDispatch();
    const { reviewlist } = useSelector(state => state.reviewReducer);

    useEffect(() => {
        dispatch(callGetReviewListAPI());
    }, []);

    return (
        <div>
            { reviewlist && reviewlist.map(review => <ReviewItem key={review.id} review={review}/>)}
        </div>
    );
}

export default ReviewList;