INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES ('web', '{bcrypt}$2a$10$A5k62FkQLiVIu6jKuqkpBu9nOFAswG13v75DQ8o3.k.UtO3ZXSi7C', 'http://localhost:8081/login', 'READ,WRITE', '3600', '10000', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');

 INSERT INTO permission (name) VALUES
 ('create_profile'),
 ('read_profile'),
 ('update_profile'),
 ('delete_profile');

 INSERT INTO role (name) VALUES
		('ROLE_manager'),('ROLE_operator');

 INSERT INTO permission_role (permission_id, role_id) VALUES
     (1,1), /*create-> manager */
     (2,1), /* read manager */
     (3,1), /* update manager */
     (4,1), /* delete manager */
     (2,2);  /* read operator */

 INSERT INTO user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('1', 'Ruchineth','{bcrypt}$2a$10$4wi00cVNOe6qddUldIGf6ePc1qTYSG4eoPeIlbVKz9/1tv0nXXJb6', 'ruchineth@ruchi.com', '1', '1', '1', '1');
 INSERT INTO user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('2', 'Dinushan', '{bcrypt}$2a$10$gGZkZIGtUNILfVWEr/4Tium.ROOltzzDfrrd6IV.1XkauUCtnVYqO','dinushan@dinu.com', '1', '1', '1', '1');

 INSERT INTO role_user (role_id, user_id)
    VALUES
    (1, 1) /* ruchineth-Manager */,
    (2, 2) /* dinushan-Operator */ ;
