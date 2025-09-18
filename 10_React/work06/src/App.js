import logo from "./logo.svg";
import { useState } from "react";
import ScForm from "./ScForm";

function App() {
  const [taskArr, setTaskArr] = useState([]);
  const [task, setTask] = useState("");
  const [dueDate, setDueDate] = useState("");

  const addTask = () => {
    if (task.trim() && dueDate.trim()) {
      setTaskArr([...taskArr, { task, dueDate }]);

      setTask("");
      setDueDate("");
    }
  };

  const delTask = (index) => {
    const newTask = taskArr.filter((_, i) => i !== index);
    setTaskArr(newTask);
  };

  return (
    <div className="App">
      <h1>할 일 목록</h1>
      <input
        value={task}
        onChange={(e) => {
          setTask(e.target.value);
        }}
        placeholder="할 일을 입력하세요"
      />
      <br />
      <input
        value={dueDate}
        onChange={(e) => {
          setDueDate(e.target.value);
        }}
        placeholder="마감일"
      />
      <input type="button" value="추가" onClick={addTask} />
      <br />

      <ScForm taskArr={taskArr} delTask={delTask} />
    </div>
  );
}
export default App;
