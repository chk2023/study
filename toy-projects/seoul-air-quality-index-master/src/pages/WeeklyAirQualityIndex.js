import {useEffect, useState} from "react";
import {getWeeklyAirQualityIndex} from "../api/AirQualityAPI"
import WeeklyAirQualityItem from "../components/WeeklyAirQualityItem";

function WeeklyAirQualityList() {
    const [WeeklyAirQualityList, setWeeklyAirQualityList] = useState();

    useEffect(() => {
        getWeeklyAirQualityIndex().then(data => setWeeklyAirQualityList(data));
    }, []);

    return (
        <div className="content-row">
            { WeeklyAirQualityList && WeeklyAirQualityList.map((WeeklyAirQuality, index) =>
                <WeeklyAirQualityItem key={index} WeeklyAirQuality={WeeklyAirQuality}/>) }
        </div>
    )
}

export default WeeklyAirQualityList;