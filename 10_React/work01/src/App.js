import logo from "./logo.svg";
import { useState } from "react";

// 색상선택 : select option (색상선택, 빨강, 파랑, 초록, 노랑)
// 색상선택 단계는 검정색 배경에 글씨없음, 색상을 선택하면 해당 색상과 글자색은 흰색 (노란색의 경우 글자색 검정으로)
function App() {
  let [selColor, setSelColor] = useState("");
  let [mfont, setFont] = useState("");

  let changeBack = (event) => {
    let color = event.target.value;
    //배경에 따른 글자색 변경
    if (color === "yellow") {
      setFont("black");
    } else {
      setFont("white");
    }
    setSelColor(color);
  };

  return (
    <div className="App">
      <select onChange={changeBack}>
        <option value="">:::색상선택:::</option>
        <option value="red">빨강</option>
        <option value="blue">파랑</option>
        <option value="green">초록</option>
        <option value="yellow">노랑</option>
      </select>
      <hr />
      <div
        id="exam_div"
        style={{
          backgroundColor: selColor,
          color: mfont,
          width: 200,
          height: 200,
          padding: 90,
        }}
      >
        {selColor}
      </div>
    </div>
  );
}
export default App;
