import React, { useState } from "react";
import MovieForm from "../components/MovieForm";
import Movie from "../components/Movie";

const Movies = () => {

    const [movies, setMovies] = useState([])

  const removeMovie = ( id ) =>{
    //alert( id );
    setMovies( movies.filter( 
      movie => { return movie.id != id } 
    ) )
  }

  const addMovie = (movie)=>{
        setMovies( [...movies, movie ] )
    }

  const renderMovies = movies.length ? movies.map( movie => {
        return(
          <Movie movie={movie} removeMovie={removeMovie}/>
        );
    }) : '등록된 영화가 없습니다';

    return(
        <div>
            <h1>Movie List</h1>
            <MovieForm addMovie={addMovie}/>
            {renderMovies}
        </div>
    )

}

export default Movies;