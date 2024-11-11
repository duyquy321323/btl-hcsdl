-- DELIMITER $$
--
-- CREATE TRIGGER update_teacher_rating
--     AFTER INSERT ON tutor_review
--     FOR EACH ROW
-- BEGIN
--     DECLARE total_rating INT;
--     DECLARE review_count INT;
--     DECLARE new_rating DECIMAL(3, 2);
--
--     -- Tính tổng điểm và số lượng đánh giá của giáo viên
--     SELECT SUM(rating), COUNT(*) INTO total_rating, review_count
--     FROM reviews
--     WHERE teacher_id = NEW.teacher_id;
--
--     -- Tính điểm trung bình
--     SET new_rating = total_rating / review_count;
--
--     -- Cập nhật điểm trung bình của giáo viên
--     UPDATE teachers
--     SET rating = new_rating
--     WHERE id = NEW.teacher_id;
-- END $$
--
-- DELIMITER ;