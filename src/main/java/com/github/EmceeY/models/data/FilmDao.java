package com.github.EmceeY.models.data;

import com.github.EmceeY.models.Film;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by User on 4/18/17.
 */
public interface FilmDao extends CrudRepository<Film, Integer> {
}
