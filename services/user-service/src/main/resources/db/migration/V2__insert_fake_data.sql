INSERT INTO users (
    id, first_name, last_name, email, password,
    items_soled, items_bought, total_rewarded, wallet_balance,
    address, country, state, city, pin_code, phone_number,
    profile_pic_url, is_verified, creation_time, last_modified, last_active_at
) VALUES
-- 1. The Power Seller
(gen_random_uuid(), 'Arjun', 'Reddy', 'arjun@test.com', 'arjun@test.com',
 120, 5, 500, 15000.00, '12 Jubilee Hills', 'India', 'Telangana', 'Hyderabad', '500033', '9000000001',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Arjun', true, NOW(), NOW(), NOW()),

-- 2. The Whale Buyer
(gen_random_uuid(), 'Priya', 'Sharma', 'priya@test.com', 'priya@test.com',
 2, 55, 1200, 50000.00, '45 Marine Drive', 'India', 'Maharashtra', 'Mumbai', '400020', '9000000002',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Priya', true, NOW(), NOW(), NOW()),

-- 3. The Techie
(gen_random_uuid(), 'Rahul', 'Verma', 'rahul@test.com', 'rahul@test.com',
 10, 10, 100, 2500.00, '88 Koramangala', 'India', 'Karnataka', 'Bangalore', '560034', '9000000003',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Rahul', true, NOW(), NOW(), NOW()),

-- 4. The Collector
(gen_random_uuid(), 'Ananya', 'Das', 'ananya@test.com', 'ananya@test.com',
 0, 12, 50, 8000.00, 'Salt Lake City', 'India', 'West Bengal', 'Kolkata', '700091', '9000000004',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Ananya', false, NOW(), NOW(), NULL),

-- 5. New User
(gen_random_uuid(), 'Vikram', 'Singh', 'vikram@test.com', 'vikram@test.com',
 0, 0, 0, 0.00, 'Sector 17', 'India', 'Chandigarh', 'Chandigarh', '160017', '9000000005',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Vikram', false, NOW(), NOW(), NULL),

-- 6
(gen_random_uuid(), 'Sneha', 'Patel', 'sneha@test.com', 'sneha@test.com',
 45, 2, 120, 4500.50, 'Navrangpura', 'India', 'Gujarat', 'Ahmedabad', '380009', '9000000006',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Sneha', true, NOW(), NOW(), NOW()),

-- 7
(gen_random_uuid(), 'Rohan', 'Mehta', 'rohan@test.com', 'rohan@test.com',
 5, 5, 20, 100.00, 'Civil Lines', 'India', 'Rajasthan', 'Jaipur', '302006', '9000000007',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Rohan', false, NOW(), NOW(), NULL),

-- 8
(gen_random_uuid(), 'Ishita', 'Gupta', 'ishita@test.com', 'ishita@test.com',
 8, 20, 200, 1200.00, 'Gomti Nagar', 'India', 'Uttar Pradesh', 'Lucknow', '226010', '9000000008',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Ishita', true, NOW(), NOW(), NOW()),

-- 9
(gen_random_uuid(), 'Kabir', 'Khan', 'kabir@test.com', 'kabir@test.com',
 200, 0, 1000, 250000.00, 'Connaught Place', 'India', 'Delhi', 'New Delhi', '110001', '9000000009',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Kabir', true, NOW(), NOW(), NOW()),

-- 10
(gen_random_uuid(), 'Meera', 'Nair', 'meera@test.com', 'meera@test.com',
 1, 1, 10, 50.00, 'Fort Kochi', 'India', 'Kerala', 'Kochi', '682001', '9000000010',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Meera', false, NOW(), NOW(), NULL),

-- 11
(gen_random_uuid(), 'Aditya', 'Chopra', 'aditya@test.com', 'aditya@test.com',
 15, 3, 60, 2200.00, 'Bandra West', 'India', 'Maharashtra', 'Mumbai', '400050', '9000000011',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Aditya', true, NOW(), NOW(), NOW()),

-- 12
(gen_random_uuid(), 'Kavya', 'Iyer', 'kavya@test.com', 'kavya@test.com',
 0, 8, 30, 600.00, 'Mylapore', 'India', 'Tamil Nadu', 'Chennai', '600004', '9000000012',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Kavya', false, NOW(), NOW(), NULL),

-- 13
(gen_random_uuid(), 'Suresh', 'Raina', 'suresh@test.com', 'suresh@test.com',
 50, 50, 500, 10000.00, 'Murad Nagar', 'India', 'Uttar Pradesh', 'Ghaziabad', '201001', '9000000013',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Suresh', true, NOW(), NOW(), NOW()),

-- 14
(gen_random_uuid(), 'Pooja', 'Hegde', 'pooja@test.com', 'pooja@test.com',
 3, 0, 10, 500.00, 'Banjara Hills', 'India', 'Telangana', 'Hyderabad', '500034', '9000000014',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Pooja', false, NOW(), NOW(), NULL),

-- 15
(gen_random_uuid(), 'Manish', 'Malhotra', 'manish@test.com', 'manish@test.com',
 500, 10, 5000, 1000000.00, 'Juhu', 'India', 'Maharashtra', 'Mumbai', '400049', '9000000015',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Manish', true, NOW(), NOW(), NOW()),

-- 16
(gen_random_uuid(), 'Simran', 'Kaur', 'simran@test.com', 'simran@test.com',
 0, 0, 0, 0.00, 'Model Town', 'India', 'Punjab', 'Ludhiana', '141002', '9000000016',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Simran', false, NOW(), NOW(), NULL),

-- 17
(gen_random_uuid(), 'Nikhil', 'Kamath', 'nikhil@test.com', 'nikhil@test.com',
 10, 100, 800, 45000.00, 'Whitefield', 'India', 'Karnataka', 'Bangalore', '560066', '9000000017',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Nikhil', true, NOW(), NOW(), NOW()),

-- 18
(gen_random_uuid(), 'Zara', 'Sheikh', 'zara@test.com', 'zara@test.com',
 2, 2, 5, 150.00, 'Park Street', 'India', 'West Bengal', 'Kolkata', '700016', '9000000018',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Zara', false, NOW(), NOW(), NULL),

-- 19
(gen_random_uuid(), 'Varun', 'Dhawan', 'varun@test.com', 'varun@test.com',
 5, 0, 15, 300.00, 'Vasant Vihar', 'India', 'Delhi', 'New Delhi', '110057', '9000000019',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Varun', false, NOW(), NOW(), NULL),

-- 20
(gen_random_uuid(), 'Deepika', 'Padukone', 'deepika@test.com', 'deepika@test.com',
 80, 80, 600, 20000.00, 'Prabhadevi', 'India', 'Maharashtra', 'Mumbai', '400025', '9000000020',
 'https://api.dicebear.com/7.x/avataaars/svg?seed=Deepika', true, NOW(), NOW(), NOW());