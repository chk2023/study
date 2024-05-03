import {Link} from "react-router-dom";

function Main() {
    return(
    <>
        <Link to="/localAirQuality">
            <div className="content-row">
                <h1>서울시 자치구별 대기환경 현황</h1>
            </div>
        </Link>
        <Link to="/weeklyAirQuality">
            <div className="content-row">
                <h1>전국 초미세먼지 주간예보 조회</h1>
            </div>
        </Link>
    </>
)
}

export default Main;