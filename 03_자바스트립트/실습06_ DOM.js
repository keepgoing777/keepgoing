const currentTime = () => {
  const weeks = ["일", "월", "화", "수", "목", "금", "토"];

  const today = new Date(); //3. 지정 및 콘솔 찍어봄
  console.log(today);
  console.log(today.getFullYear()); //년
  console.log(today.getMonth() + 1); //월(0:1월 1:2월 2:3월)
  console.log(today.getDate()); //일
  console.log(today.getDay()); // 결과값 3 요일(0:일 1:월 2:화 )
  console.log(weeks[3]);
  console.log(weeks[today.getDay()]);

  const year = today.getFullYear(); //4. 최종 지정
  const month = today.getMonth() + 1;
  const day = today.getDate();
  const week = weeks[today.getDay()];

  const current = document.querySelector("#current"); // 1. html 지정 태그 가져옴
  console.log(current); //2. 콘솔 일단 찍어봄
  current.innerHTML = `${year}년 ${month}월 ${day}일 (${week})`; //6.HTML 들어가기 전 형식 맞추기

  const h1 = document.querySelector("h1"); // 1. html 태그 가져옴
  console.log(today.getHours()); //시 2. 콘솔 확인
  console.log(today.getMinutes()); //분
  console.log(today.getSeconds()); //초

  const hour = today.getHours(); //3. 지정
  const minute = String(today.getMinutes()).padStart(2, "0");
  const second = String(today.getSeconds()).padStart(2, "0");

  h1.textContent = `${hour}:${minute}:${second}`;
};

const randomBackground = () => {
  const body = document.body; // querySelector 써도 되고 body써도 되고
  const backGround = [
    "#ED833A",
    "#EA839B",
    "#42B667",
    "#FFC228",
    "#005456",
    "#ACDED5",
  ];
  body.style.background =
    backGround[Math.floor(Math.random() * backGround.length)];

  // 다른 방법
  const r = Math.floor(Math.random() * 256);
  const g = Math.floor(Math.random() * 256);
  const b = Math.floor(Math.random() * 256);
  body.style.backgound = `rgba(${r}, ${g}, ${b}, 0.4)`;
};

const count = () => {
  const last = new Date("2026-01-01 00:00:00"); //목표하는 날짜
  const now = new Date(); // 현재 날짜
  // console.log(Math.floor((last - now) / 1000)); //1초 = 밀리세컨드/1000
  const second = Math.floor((last - now) / 1000);
  const minute = Math.floor(second / 60);
  const hour = Math.floor(minute / 60);
  const day = Math.floor(hour / 24);
  console.log(day);
  console.log(hour) % 24;
  console.log(minute % 60);
  console.log(second % 60);
  const count = document.querySelector("#count");
  count.innerHTML = `올해 남은 시간 ${day}일 ${hour % 26}시간 ${
    minute % 60
  }분 ${second % 60}초`;
};

import quotes from "./실습06_인용.js"; // import quotes from "파일" + ".js"
//콘솔 찍어보면 오류 남 > html 파일 내 스크립트 링크 들어간 부분에 type="module" 을 추가 기재해야함

const randomQuote = () => {
  const random = quotes[Math.floor(Math.random() * quotes.length)]; //background 했던 방법 동일 //
  const quoteE = document.querySelector("#quoteE");
  const quoteK = document.querySelector("#quoteK");
  console.log(random.en);
  console.log(random.ko);
  quoteE.innerHTML = random.en;
  quoteK.innerHTML = random.ko;
};

currentTime();
randomBackground();
count();
randomQuote();

setInterval(() => {
  currentTime();
  count();
}, 1000); //1000 = 1초

setInterval(() => {
  randomBackground();
  randomQuote();
}, 2000);
