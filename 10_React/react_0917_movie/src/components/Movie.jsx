import React from "react";

//function Movie(){}
const Movie = ( {movie, removeMovie} )=>{
    return(
        <div className="movie">
            <div className="movie-title">
                { movie.title }

                <span className="movie-year">
                    ( { movie.year } )
                </span>

            </div>

            <div>
                <input type="button" value="삭제" 
                       onClick={ ()=>{ removeMovie(movie.id) } }/>
            </div>
            
        </div>
    )
}

export default Movie;