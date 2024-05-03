const BASE_URL = 'https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/';
const API_KEY = 'G2%2BHIQfcflRwwN6AEzJvRJBo6HJ7W%2Bl1tj9Q5m9cifAS09Xxv3kGjhQYyUfDuLaT7BtAYS9NCOkG%2BIvBP%2BvwBA%3D%3D';

export async function getLocalAirQualityIndex() {
    const url = `${BASE_URL}getCtprvnRltmMesureDnsty?serviceKey=${API_KEY}&returnType=json&numOfRows=100&pageNo=1&sidoName=서울&ver=1.0`
    const response = await fetch(url);
    const data = await response.json();
    console.log(data);
    return data.response.body.items;
}

export async function getWeeklyAirQualityIndex() {
    const url = `${BASE_URL}getMinuDustWeekFrcstDspth?serviceKey=${API_KEY}&returnType=json&numOfRows=100&pageNo=1&searchDate=2024-05-01`
    const response = await fetch(url);
    const data = await response.json();
    console.log(data);
    return data.response.body.items;
}