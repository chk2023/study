function WeeklyAirQualityItem({WeeklyAirQuality}) {
    return (
        <div className="item">
            <h3>날짜 : {WeeklyAirQuality.frcstOneDt}</h3>
            <h3>so2 수치 : {WeeklyAirQuality.frcstOneCn}</h3>
        </div>
    );
}

export default WeeklyAirQualityItem;