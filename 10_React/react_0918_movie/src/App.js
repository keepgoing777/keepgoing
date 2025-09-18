import Movie from "./components/Movie";
import logo from "./logo.svg";
import { dummy } from "./movieDummy";
import "./index.css";

function App() {
  return (
    <div className="app-container">
      {dummy.results.map((item) => {
        return (
          <Movie
            title={item.title}
            poster_path={item.poster_path}
            vote_average={item.vote_average}
          />
        );
      })}
    </div>
  );
}

export default App;
