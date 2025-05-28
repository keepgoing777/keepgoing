// DOMContentLoaded 이벤트는 HTML 문서의 구조가 완전히 로드된 후 발생

window.addEventListener("DOMContentLoaded", () => {
  const h1 = document.querySelector("h1");
  h1.style.color = "blue";

  //클릭 이벤트
  const click = document.querySelector("#click");
  click.addEventListener("click", () => {
    // 클릭 이벤트가 일어나면 행하고자 하는 코드 작성
    alert("클릭 이벤트 발생!");
    click.style.background = "hotpink";
  });

  //더블 클릭 이벤트
  const double = document.querySelector("#double");
  double.addEventListener("dblclick", () => {
    alert("더블 클릭 발생!");
  });

  const right = document.querySelector("#right");
  right.addEventListener("contextmenu", (event) => {
    alert("우클릭 발생!");
    event.preventDefault(); // 또는 alert를 지우고 이 문장만 사용해도 우클릭 방지됨
  });

  const hover = document.querySelector("#hover");
  hover.addEventListener("mouseenter", () => {
    console.log("mouseenter!");
    hover.style.background = "lightblue";
    hover.textContent = "Mouse Enter!";
    // 배경 색상은 lightblue, 텍스트는 Mouse Enter! 변경
  });
  hover.addEventListener("mouseleave", () => {
    console.log("mouseleave!");
    hover.style.background = "navy";
    hover.textContent = "Mouse Leave!";
    // 배경 색상은 navy, 텍스트는 Mouse Leave! 변경
  });

  // 폼이벤트
  // input 실시간 반영

  const input = document.querySelector("#input");
  const inputResult = document.querySelector("#inputResult");
  input.addEventListener("input", (e) => {
    console.log(e.target.value);
    inputResult.innerHTML = e.target.value;
  });

  // select 선택값 출력
  const select = document.querySelector("#select");
  const selectResult = document.querySelector("#selectResult");
  select.addEventListener("change", (e) => {
    console.log(e.target.value);
    selectResult.innerHTML = e.target.value;
  });

  // form 제출 불가
  const form = document.querySelector("#form");
  const inputText = document.querySelector("#form input");
  form.addEventListener("submit", (e) => {
    // 값이 없는 경우만 전송 불가, 값이 있으면 전송
    if (inputText.value === "") e.preventDefault();
    console.log(inputText.value);
  });

  //   키보드 이벤트 (key down(키 누르는 순간), keypress(키보드 누르고 있는 순간), keyup(키보드에서 손을 떼는 순간))
  const keyboard = document.querySelector("#keyboard");
  const keyResult = document.querySelector("#keyResult");
  keyboard.addEventListener("keydown", (e) => {
    console.log(e.key);
    keyResult.innerHTML = e.key;
    if (e.key === "Enter") {
      alert("엔터!");
    }
  });

  //   박스 움직이기
  const move = document.querySelector(".movebox");
  let x = 0,
    y = 0;
  document.addEventListener("keydown", (e) => {
    console.log(e.key);
    if (e.key === "ArrowUp") {
      // top이 마이너스인 경우
      y += -5;
    } else if (e.key === "ArrowDown") {
      y += +5;
    } else if (e.key === "ArrowRight") {
      x += +5;
    } else if (e.key === "ArrowLeft") {
      x += -5;
    }
    move.style.top = `${y}px`;
    move.style.left = `${x}px`;
  });

  //  스크롤 이벤트
  const wheel = document.querySelector("#wheel");
  const scroll = document.querySelector("#scroll");
  window.addEventListener("wheel", (e) => {
    //  console.log(e.deltaY); // 휠을 올리면 마이너스, 휠을 내리면 플러스
    if (e.deltaY < 0) wheel.textContent = "휠 위로 스크롤 중!";
    else if (e.deltaY > 0) wheel.textContent = "휠 아래로 스크롤 중!";
  });

  window.addEventListener("scroll", () => {
    console.log("scrollHeight", document.documentElement.scrollHeight); // 고정값 : 스크롤 전체 높이
    console.log("innerHeight", window.innerHeight); // 고정값 : 보여지는 화면 높이
    console.log("scrollY", window.scrollY); // 변수값 : 스크롤 내리는 높이
    // scrollHeight === innerHeight + scrollY
    // scrollHeight - innerHeight = scrollY 스크롤 총 내리는 높이
    const totalHeight =
      document.documentElement.scrollHeight - window.innerHeight;
    const percent = (window.scrollY / totalHeight) * 100;
    console.log(percent);
    scroll.style.width = `${percent}%`;
  });

  // 이벤트 위임
  // 이미지가 클릭될 때마다 해당 이미지 지우기
  // 1. 이미지마다 이벤트 걸려면 직접 for 반복문 사용
  // const img = document.querySelectorAll(".container img");
  // for (let i = 0; i < img.length; i++) {
  // console.log(img[i]); 확인용
  //   img[i].addEventListener("click", (e) => {
  //    img[i].style.display = "none";
  //  console.log(e.currentTarget); 확인용
  // e.currentTarget.style.display = "none"; 으로 사용 가능
  //  });
  // }

  // 2. 부모인 컨테이너에 이벤트 걸기
  const container = document.querySelector(".container");
  console.log(container);
  const removeHandler = (e) => {
    console.log("target", e.target); //내가 클릭한 이미지
    console.log("current", e.currentTarget); //이벤트 걸린 본인
    if (e.target !== e.currentTarget) {
      e.target.style.display = "none";
    }
  };
  container.addEventListener("click", removeHandler);
});
