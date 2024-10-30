package com.sasindu.reviews;

import com.sasindu.movies.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MongoTemplate mongoTemplate;

    public Review createMovieReview(ReviewRequest reviewRequest) {
        // Insert the new review
        Review review = reviewRepository.insert(new Review(reviewRequest.getBody(), LocalDateTime.now(), LocalDateTime.now()));

        // Create query and update objects for adding the review ID to the Movie document
        Query query = new Query(Criteria.where("imdbId").is(reviewRequest.getImdbId()));
        Update update = new Update().push("reviewIds", review);

        // Update the movie by adding the new review ID to the reviewIds array
        mongoTemplate.updateFirst(query, update, Movie.class);

        return review;
    }
}
