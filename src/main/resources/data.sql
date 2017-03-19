INSERT IGNORE INTO users (id, login, password, role, created_date, modified_date) VALUES
  (1, 'egor', 'egor', 'ROLE_ADMIN', '1', '1');

INSERT IGNORE INTO country (id, name_en, name_ru, iso2, iso3, phone_code) VALUES
  (1, 'Ukraine', 'Украина', '123', '1', '+380');

INSERT IGNORE INTO region (id, name_en, name_ru, country_name, created_date, modified_date) VALUES
  (1, 'Ukraine', 'Украина', 1, current_timestamp, current_timestamp);

INSERT IGNORE INTO city (id, name_en, name_ru, region_id, created_date, modified_date) VALUES
  (1, 'Odessa', 'Одесса', 1, CURRENT_TIMESTAMP, current_timestamp);

INSERT IGNORE INTO category (id, name, status, created_date, modified_date) VALUES
  (1, 'sport', 'active', current_timestamp, current_timestamp);

INSERT IGNORE INTO ds.discount_system (id, license, authorized, background_image, code_format, color, country_id, created_date, email, logo, modified_date, subname, status, tags, tel_name, tel_number, title, url, category, country)
VALUES
  (1, 'sdf', NULL, NULL, 'QR', 'sdf', 0, current_timestamp, NULL,
      'tdgzpt2jdbtsgoy4rtqf', current_timestamp, 'sdf',
   NULL, NULL,
   'sdf', 'sdf', 'sdf', 'sf', 1, 1);

INSERT IGNORE INTO ds.shop_mall (id, license, additional_adress, background_image, color,
                          created_date, email, logo, latitude, longtitude, modified_date,
                          name, post_code, status, street, subname, phone_title, phone, title,
                          url, city, country, region)
VALUES (1, 'dfg', 'sdf', 'y2i50scln6hoqvosgxcy', 'sdf', current_timestamp, 'sdf@df',
           'b67yxoceovgvnrtncr7j', NULL, NULL, current_timestamp, 'dfg', 'sdf',
            'yes', 'sdf', 'dfg', 'dfg', 'dfg', 'dfg', 'dfg', 1, 1, 1);