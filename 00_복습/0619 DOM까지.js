function btn1() {
  console.log(document.body); // <body>...</body>
  const h3 = document.getElementsByTagName("h3");
  const divs = document.getElementsByTagName("div");
  console.log(divs); // HTML collection(5) 배열
  console.log(divs[0]); // hello world!
}

function btn2() {
  const testId = document.getElementById("testId");
  console.log(testId);
  const testId2 = document.getElementById("testId2");
  console.log(testId2);
}

function btn3() {
  const div = document.getElementsByClassName("testClass");
  console.log(div);
  console.log(div[1]);
}

function btn4() {
  const div = document.getElementsByName("testName");
  console.log(div);
}

function btn5() {
  const div = document.querySelector("#testId");
  console.log(div);
  const divs = document.querySelectorAll("div");
  console.log(divs);
}

function btn6() {
  const divs = document.querySelectorAll(".testClass");
  divs[0].textContent = "<span>안녕하세요</span>";
  console.log(divs[0].textContent);
  divs[1].innerHTML = "<span>안녕하세요</span>";
  console.log(divs[1].innerHTML);
}

function btn7() {
  const div = document.querySelector("#testId");
  div.setAttribute("data-test", "테스트");
  console.log(div.getAttribute("data-test"));
  console.log(div.getAttribute("class"));
}

function btn8() {
  const div = document.querySelector("#testId");
  div.style.color = "orange";
  div.style.backgroundColor = "yellow";
}

const div2 = document.querySelector("#testId2");
function btn9() {
  div2.classList.add("black");
}

function btn10() {
  div2.classList.remove("black");
}

function btn11() {
  const has = div2.classList.contains("black");
  console.log("black 클래스가 있는지:", has);
  if (has == true) div2.classList.remove("black");
  else div2.classList.add("black");
}

function btn12() {
  div2.classList.toggle("black");
}

function btn13() {
  const div = document.querySelector("#testId3");
  const p = document.createElement("p");
  p.textContent = "텍스트 추가";
  div.appendChild(p); //div 안의 자식으로 p태그 포함
}

function btn14() {
  const testId3 = document.querySelector("#testId3");
  const p = document.querySelector("#testId3 p");
  //testId3.removeChild(p);
  if (p !== null) p.remove;
}
