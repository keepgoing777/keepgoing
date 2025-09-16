import logo from "./logo.svg";
import { useState } from "react";

function App() {
  let [level, setLevel] = useState("");

  //강도에 따른 운동종류
  let excercise = {
    light: {
      title: "산책",
      description: "가볍게 몸을 풀어보세요",
    },
    medium: {
      title: "조깅",
      description: "적당한 운동으로 컨디션을 유지하세요",
    },
    hard: {
      title: "마라톤",
      description: "마라톤으로 체력을 키우세요",
    },
  };

  let selected = excercise[level];

  return (
    <div className="App">
      <h2>오늘 어떤 운동을 하시겠어요?</h2>
      <div>
        <button
          onClick={() => {
            setLevel("light");
          }}
        >
          가벼운 운동
        </button>
        <button
          onClick={() => {
            setLevel("medium");
          }}
        >
          중간강도 운동
        </button>
        <button
          onClick={() => {
            setLevel("hard");
          }}
        >
          고강도 운동
        </button>
      </div>
      {/*selected에 값이 있을 때만 div를 생성 */}
      {selected && (
        <div>
          <h3>{selected.title}</h3>
          <p>{selected.description}</p>
        </div>
      )}
    </div>
  );
}

export default App;
