import {useEffect, useState} from "react";
import {getLocalAirQualityIndex} from "../api/AirQualityAPI"
import LocalAirQualityItem from "../components/LocalAirQualityItem";

function LocalAirQualityList() {
    const [LocalAirQualityList, setLocalAirQualityList] = useState();

    useEffect(() => {
        getLocalAirQualityIndex().then(data => setLocalAirQualityList(data));
    }, []);

    return (
        <div className="content-row">
            { LocalAirQualityList && LocalAirQualityList.map((localAirQuality, index) =>
                <LocalAirQualityItem key={index} localAirQuality={localAirQuality}/>) }
        </div>
    )
}

export default LocalAirQualityList;