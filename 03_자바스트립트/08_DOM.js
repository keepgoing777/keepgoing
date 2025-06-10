function btn1() {
  console.log(document.body);

  const h2 = document.getElementsByTagName("h2");
  const divs = document.getElementsByTagName("div");
  //   모든 div 태그 가져오기
  console.log(h2);
  console.log(divs);
  console.log(divs[0]); //첫번째 div //
  // 같은 태그로 여러개일 수 있어서 배열로 반환 받음 //
}

function btn2() {
  const testId = document.getElementById("testId");
  console.log(testId);

  const testId2 = document.getElementById("testId2");
  console.log(testId2);
}
// id로 가져오기 : 고유 값이라서 배열 아님, 하나의 태그 선택//

function btn3() {
  const div = document.getElementsByClassName("testClass");
  console.log(div);
  console.log(div[1]);
}

//class으로 가져오기 : 같은 클래스 명이 여러개일 수 있으므로 배열로 반환 //

function btn4() {
  const div = document.getElementsByName("testName");
  console.log(div);
}

// name으로 가져오기 : 같은 name 속성이 여러개일 수 있으므로 배열로 반환

function btn5() {
  const div = document.querySelector("#testId");
  console.log(div);
  // 한 개만 가지고 오고 싶으면 queryselector //

  const divs = document.querySelectorAll("div");
  console.log(divs);
  // 여러개를 가지고 오고 싶으면 queryselectorAll //
}

// QuerySelector 사용 시 CSS 선택자 문법 사용 가능 //

function btn6() {
  const divs = document.querySelectorAll(".testClass");
  divs[0].textContent = "<span>안녕하세요</span>"; // 태그를 문자로 출력 //
  divs[1].innerHTML = "<span>안녕하세요</span>"; // 태그를 HTML로 출력//
  console.log(divs[0].textContent);
  console.log(divs[1].innerHTML);
}

function btn7() {
  const div = document.querySelector("#testId");
  // 새로운 속성 추가, 삭제, 즉 수정 가능 //
  div.setAttribute("data-test", "테스트");
  // set.Attribute(속성명, 속성값)
  console.log(div.getAttribute("data-test"));
  console.log(div.getAttribute("class"));
}
// div.removeAttribute("id") //

function btn8() {
  const div = document.querySelector("#testId");
  div.style.color = "orange";
  div.style.backgroundColor = "yellow";
}

const div2 = document.querySelector("#testId2");
function btn9() {
  div2.classList.add("black"); // black 클래스 추가 //
}

function btn10() {
  div2.classList.remove("black"); //black 클래스 삭제 //
}

function btn11() {
  const has = div2.classList.contains("black");
  console.log("black 클래스가 있는지:", has);
  // black 클래스가 있다면 제거, 없다면 추가 //
  if (has == true) div2.classList.remove("black");
  else div2.classList.add("black");
}

function btn12() {
  div2.classList.toggle("black");
}

function btn13() {
  const div = document.querySelector("#testId3");
  const p = document.createElement("p"); // p 태그 생성 //
  p.textContent = "텍스트 추가"; // p 태그 안에 텍스트 내용 추가 //
  div.appendChild(p); // div안에 자식으로 p태그를 넣겠다 //
}
function btn14() {
  const testId3 = document.querySelector("#testId3");
  const p = document.querySelector("#testId3 p");
  // testId3.removeChild(p); 부모를 통해 삭제하는 방법 //
  if (p !== null) p.remove(); // 최신 브라우저에서 지원 (거의 지원)
  // if (p)
}
