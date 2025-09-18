import React from "react";

const IMG_BASE_URL = "https://image.tmdb.org/t/p/w1280/";

export default function Movie({ title, poster_path, vote_average }) {
  return (
    <div className="movie-container">
      <img src={IMG_BASE_URL + poster_path} />
      <div className="movie-info">
        <h4>{title}</h4>
        <h4>{vote_average}</h4>
      </div>
    </div>
  );
}

// const Movie = () => {}
// export default Movie; => export default function Movies() {} 대체
