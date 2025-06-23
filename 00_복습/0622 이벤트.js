window.addEventListener("DOMContentLoaded", () => {
  const h1 = document.querySelector("h1");
  h1.style.color = "blue";

  const click = document.querySelector("#click");
  click.addEventListener("click", () => {
    alert("클릭");
    click.style.background = "hotpink";
  });

  const double = document.querySelector("#double");
  double.addEventListener("dblclick", () => {
    alert("더블클릭");
  });

  const right = document.querySelector("#right");
  right.addEventListener("contextmenu", (event) => {
    alert("우클릭");
    event.preventDefault();
  });

  const hover = document.querySelector("#hover");
  hover.addEventListener("mouseenter", () => {
    hover.style.background = "lightblue";
    hover.textContent = "Mouse Enter!";
  });

  const input = document.querySelector("#input");
  const inputResult = document.querySelector("#inputResult");
  input.addEventListener("input", (e) => {
    inputResult.innerHTML = e.target.value;
    //e.target.value; = 현재 입력값을 가져옴
  });

  const select = document.querySelector("#select");
  const selectResult = document.querySelector("#selectResult");
  select.addEventListener("change", (e) => {
    console.log(e.target.value);
    selectResult.innerHTML = e.target.value;
  });

  const form = document.querySelector("#form");
  const inputText = document.querySelector("#form input");
  form.addEventListener("submit", (e) => {
    if (inputText.value === " ") e.preventDefault();
    alert("제출불가");
  });

  const keyboard = document.querySelector("#keyboard");
  const keyResult = document.querySelector("#keyReult");
  keyboard.addEventListener("keydown", (e) => {
    keyResult.innerHTML = e.key;
    console.log(e.key);
    //e.key = 키보드 키 누른 값
    if (e.key === "Enter") {
      alert("엔터!");
    }
  });

  const move = document.querySelector(".movebox");
  let x = 0,
    y = 0;
  document.addEventListener("keydown", (e) => {
    console.log(e.key);
    if (e.key === "ArrowUp") {
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

  const wheel = document.querySelector("#wheel");
  const scroll = document.querySelector("#scroll");
  window.addEventListener("wheel", (e) => {
    if (e.deltaY < 0) wheel.textContent = "휠 위로 스크롤 중!";
    else if (e.deltaY > 0) wheel.textContent = "휠 아래로 스크롤 중!";
  });

  window.addEventListener("scroll", () => {
    console.log("scrollHeight", document.documentElement.scrollHeight);
    console.log("innerHeight", window.innerHeight);
    console.log("scrollY", window.scrollY);
    //scrollHeight = innerHeight + scrollY
    const totalHeight =
      document.documentElement.scrollHeight - window.innerHeight;
    const percent = (window.scrollY / totalHeight) * 100;
    console.log(percent);
    scroll.style.width = `${percent}%`;
  });
  /* for구문으로 직접 이미지 클릭할때마다 지우기
  const img = document.querySelectorAll(".container img");
   for (let i = 0 ; i < img.length ; i++) {
    console.log(img[i]);
    img[i].addEventListener("click", (e) => {
      img[i].style.display = "none";
      //e.currentTarget.style.display = "none";
    })
   }
   */
  // 2. 부모인 컨테이너에 이벤트 걸기
  const container = document.querySelector(".container");
  const removeHander = (e) => {
    if (e.target !== e.currentTarget) {
      e.target.style.display = "none";
    }
  };
  container.addEventListener("click", removeHander);
});
