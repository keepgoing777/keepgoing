// 1번 문제
const div = document.querySelector("#result1");
function printText() {
  div.textContent = "안녕하세요";
  // div.innerHTML = "안녕하세요";//
  console.log(div);
}

// 2번 문제
const customer = document.querySelector("#customer");
const result2 = document.querySelector("#result2");
function printInputValue() {
  console.log(customer.value);
  result2.textContent = customer.value;
  customer.value = "";
}
//  input 값 (customer.value)을 가지고 오기(console로 확인)
//  가지고 와서 result2에 출력하기 (1번 문제와 동일)
//  input 값을 비우기

// 3번 문제
const divTest = document.querySelector(".div-test");
function changeColor() {
  divTest.style.background = "yellow";
}
// 선택한 divTest의 배경색을 변경시켜라

// 4번 문제
const text = document.querySelector("#text");
const result4 = document.querySelector("#result4");
function stringLength() {
  console.log(text.value.length);
  result4.innerHTML = text.value.length;
  text.value = "";
}
// 입력된 값 가져오기, 값의 길이 구하기, 가져온 값 출력하기, 비우기

// 5번 문제
const la = document.querySelector("#la");
const result5 = document.querySelector("#result5");

console.log(la.innerHTML);
const laText = la.innerHTML; //가져오기

console.log(laText.split(","));
const laArr = laText.split(","); //쪼개기

function stringSplit() {
  const ul = document.createElement("ul");
  for (let i = 0; i < laArr.length; i++) {
    //  console.log(laArr[i]);
    const li = document.createElement("li");
    li.textContent = laArr[i];
    console.log(li);
    // ul.appendChild(li);
    // ul.innerHTML = "<li>" + laArr[i] + "</li>";//
    ul.innerHTML += `<li>${laArr[i]}</li>`;
  }
  console.log(ul);
  result5.appendChild(ul);
}
// 사과, 바나나, 오렌지, 포도 문자 가져오기
// 가지고 온 문자열 분리하기 (배열로 만들기)
// 배열값 하나씩 가져오기 (반복문)
// 반복문에서 태그를 만들어서 출력

const preview = document.querySelector("#preview");
const remove = document.querySelector("#remove");
const add = document.querySelector("#add");

// 6번 문제
function arrayTest() {
  console.log(preview.textContent.split(" "));
  const preArr = preview.textContent.split(" ");
  for (let i = 0; i < preArr.length; i++) {
    if (preArr[i] === "remove.value") {
      preArr.splice(i, 1);
    }
    // 이미 가지고 있는 값에서 내가 삭제할 값이 일치하면 배열에서 제거
    // 확인과정  console.log(preArr[i]) === "피자";
  }
  console.log(preArr, join(" "));

  preArr.push(add.value);
}

// 배열에서 제거 : splice (인덱스, 1);
// const delIdx = preArr.indexof(remove.value) 삭제할 인덱스
// console.log(delIdx);
// preArr.splice(delIdx, 1); 제거할 인덱스 필요
// if (delIdx !== -1) preArr.splice(delIdx, 1);
// console.log(preArr.includes(remove.value)); 배열에서도 해당값이 있는지 없는지 확인가능 (delIdx !==-1 대체 가능)

// 추가 : 배열에 해당하는 값 추가

// 7번 문제 prompt로 이름, 나이, 주소 순으로 입력받아서 출력
const names = document.querySelectorAll(".name");
const ages = document.querySelectorAll(".age");
const addrs = document.querySelectorAll(".addr");

function addStudent() {
  // 확인용 console.log(names)
  for (let i = 0; i < 3; i++) {
    const name = prompt(`${i}학생 이름`);
    const age = prompt(`${i}번째 나이`);
    const addr = prompt(`${i}번째 주소`);

    names[i].textContent = name;
    ages[i].textContent = age;
    addr[i].textContent = addr;
  }
}

// 8번

const list = document.querySelector("#list");
function addItem() {
  //1. li 태그를 만들어서 추가하는 방식
  const li = document.createElement("li");
  li.textContent = "테스트";
  list.appendChild(li);

  //2. innerHTML로 문자 추가 하는 방식
  // list.innerHTML +="<li>테스트</li>"
  const div = document.querySelector(list);
  div.classList.add("addItem");
}

function removeItem() {
  //1. 부모에서 제거
  console.log(list.childNodes);
  list.removeChild(list.childNodes[0]);
  //2. 본인이 제거
  const li = document.querySelector("#list li");
  li.remove();
  const div = document.querySelector(list);
  div.classList.add("addItem");
}

// 9번
const result9 = document.querySelector("#result9");
function toggleClass() {
  result9.classList.toggle("active");
}

// 10번
const itme = document.querySelector("#item");
const price = document.querySelector("#price");
const cart = document.querySelector("#cart");
const total = document.querySelector("#total span");
let sum = 0;
function addToCart() {
  cart.innerHTML += `<li>${itme.value} - ${price.value}</li>`;
  console.log(isNaN(Numver(price.value)));
  if (!isNaN(Number(price.value))) sum += Number(price.value); //value값 비우기 전에 기재할 것
  total.innerHTML = sum;
  console.log(sum);
  itme.value = "";
  price.value = "";
  //  가격에 문자를 넣었을 경우 NaN원이 뜸
}
