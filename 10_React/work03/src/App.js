import logo from "./logo.svg";
import { useState } from "react";

// 버튼 3개 + 0 - : + 눌렀을때 숫자 1 증가 갱신, - 눌렀을때 숫자 1 감소 갱신
// 인풋값을 span에 표시
// 짝수 홀수 확인버튼 누르면 후 숫자는 span에, 짝수 홀수 확인 메시지는 따로 표시, 0일때는 0이라고 표시
function App() {
  let [num, setNum] = useState(0);
  let [msg, setMsg] = useState("");

  function down() {
    setNum(--num);
  }

  function reset() {
    setNum(0);
  }

  function up() {
    setNum(num++);
  }

  function changeNum(event) {
    setNum(Number(event.target.value));
  }

  function checkNum() {
    if (num == 0) {
      setMsg("현재 카운트는 0입니다");
    } else if (num % 2 == 0) {
      setMsg("짝수");
    } else {
      setMsg("홀수");
    }
  }

  return (
    <div className="App">
      <input type="button" value="-" onClick={down} />
      <input type="button" value="0" onClick={reset} />
      <input type="button" value="+" onClick={up} />
      <input type="text" value={num} onChange={changeNum} />
      <span>{num}</span> <br />
      <input type="button" value="짝수/홀수 확인" onClick={checkNum} />
      <br />
      <span>{msg}</span>
      <br />
    </div>
  );
}

export default App;
