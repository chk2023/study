function LocalAirQualityItem({localAirQuality}) {
    return (
            <div className="item">
                <h3>위치 : {localAirQuality.stationName}</h3>
                <h3>so2 수치 : {localAirQuality.so2Value}</h3>
                <h3>co 수치 : {localAirQuality.coValue}</h3>
                <h3>pm10 수치 : {localAirQuality.pm10Value}</h3>
                <h3>시간 : {localAirQuality.dataTime}</h3>
            </div>
    );
}

export default LocalAirQualityItem;