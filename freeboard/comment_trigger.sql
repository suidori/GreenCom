DELIMITER //

CREATE TRIGGER before_insert_comment
BEFORE INSERT ON comment
FOR EACH ROW
BEGIN
    DECLARE new_c_idx INT;

    SELECT IFNULL(MAX(c_idx), 0) INTO new_c_idx
    FROM comment
    WHERE fidx = NEW.fidx;

    SET new_c_idx = new_c_idx + 1;

    SET NEW.c_idx = new_c_idx;
END //

DELIMITER ;
