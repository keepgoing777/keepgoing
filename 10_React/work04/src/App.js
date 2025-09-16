import logo from "./logo.svg";
import { useState } from "react";

function App() {
  let [greet, setGreet] = useState("");
  let [msg, setMsg] = useState("");

  function nameChange(event) {
    event.preventDefault();
    let name = event.target.myname.value;
    setGreet("안녕하세요 " + name + "님, 오늘의 기분은 어떠세요?");
  }

  function moodChange(event) {
    let mood = event.target.value;
    if (mood === "행복") {
      setMsg(mood + " 좋은날이네요");
    } else if (mood === "슬픔") {
      setMsg(mood + " 흐규흐규");
    } else if (mood === "화남") {
      setMsg(mood + " 으아아악!!");
    } else {
      setMsg("");
    }
  }

  return (
    <div className="App">
      <form onSubmit={nameChange}>
        <input type="text" name="myname" placeholder="이름을 입력하세요" />
        <input type="submit" value="인사하기" /> <br />
      </form>
      <p>{greet}</p>

      {/*기분을 선택하는 select 태그 */}
      <div>
        <select onChange={moodChange}>
          <option value="">기분을 선택해주세요</option>
          <option value="행복">행복</option>
          <option value="슬픔">슬픔</option>
          <option value="화남">화남</option>
        </select>
        <br />
        <p>{msg}</p>
      </div>
    </div>
  );
}

export default App;
