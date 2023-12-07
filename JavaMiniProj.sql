create database quizzer;

create table login(username varchar(30),
					pass varchar(30),
                    TSAScore numeric,
                    JSLScore numeric,
                    ISScore numeric);

drop table login;

select * from login;

-- Create the table
CREATE TABLE TimeSeriesQuestions (
    Qno INT PRIMARY KEY,
    Qtext TEXT,
    Opt1 TEXT,
    Opt2 TEXT,
    Opt3 TEXT,
    Opt4 TEXT,
    CorrAns VARCHAR(1)
);

-- Insert data into the table
INSERT INTO TimeSeriesQuestions (Qno, Qtext, Opt1, Opt2, Opt3, Opt4, CorrAns)
VALUES
(1, 'What is the primary purpose of time series analysis?', 'A. Predicting future values', 'B. Classifying data points', 'C. Summarizing data distributions', 'D. Analyzing spatial patterns', 'A'),
(2, 'Which of the following is a common component in time series decomposition?', 'A. Seasonality', 'B. Skewness', 'C. Outliers', 'D. Mean absolute deviation', 'A'),
(3, 'In time series analysis, what does autocorrelation measure?', 'A. Association between two variables', 'B. Correlation of a variable with its past values', 'C. Correlation between two independent variables', 'D. Variability within a time series', 'B'),
(4, 'What is the difference between a moving average and exponential smoothing in time series forecasting?', 'A. Moving average uses past values equally, while exponential smoothing gives more weight to recent values', 'B. Exponential smoothing uses past values equally, while moving average gives more weight to recent values', 'C. Moving average considers only recent values, while exponential smoothing considers all past values', 'D. Exponential smoothing considers only recent values, while moving average considers all past values', 'A'),
(5, 'Which time series model is suitable for data with a linear trend and constant variance?', 'A. Autoregressive Integrated Moving Average (ARIMA)', 'B. Seasonal Decomposition of Time Series (STL)', 'C. Holt-Winters Exponential Smoothing', 'D. GARCH (Generalized Autoregressive Conditional Heteroskedasticity)', 'A'),
(6, 'What is the purpose of differencing in time series analysis?', 'A. To remove seasonality', 'B. To stabilize the variance', 'C. To make the time series stationary', 'D. To identify outliers', 'C'),
(7, 'Which statistical test is commonly used to test for stationarity in a time series?', 'A. T-test', 'B. ANOVA', 'C. Augmented Dickey-Fuller test', 'D. Chi-square test', 'C'),
(8, 'What does the term "lag" refer to in the context of time series analysis?', 'A. The delay between cause and effect', 'B. The time period between data points', 'C. The order of differencing', 'D. The presence of outliers', 'B'),
(9, 'Which of the following is a characteristic of a white noise time series?', 'A. Seasonal patterns', 'B. Autocorrelation in residuals', 'C. Constant mean and variance', 'D. Trends and cycles', 'C'),
(10, 'What is the purpose of cross-validation in time series forecasting?', 'A. To check for multicollinearity', 'B. To assess the accuracy of the model on unseen data', 'C. To test for stationarity', 'D. To identify outliers', 'B');

UPDATE TimeSeriesQuestions
SET Qtext = 'What is a characteristic of Exponential Smoothing in time series forecasting?',
    Opt1 = 'A. Equal weight to all past values',
    Opt2 = 'B. Increasing weight to recent values',
    Opt3 = 'C. Considers only recent values',
    Opt4 = 'D. Decreasing weight to recent values',
    CorrAns = 'D'
WHERE Qno = 4;

drop table timeseriesquestions;

SELECT * from TimeSeriesQuestions;

-- Create table for Java and Scala Basics Questions
CREATE TABLE JavaScalaQuestions (
    Qno INT PRIMARY KEY,
    Qtext TEXT,
    Opt1 TEXT,
    Opt2 TEXT,
    Opt3 TEXT,
    Opt4 TEXT,
    CorrAns VARCHAR(1)
);

-- Insert Java and Scala Basics Questions
INSERT INTO JavaScalaQuestions (Qno, Qtext, Opt1, Opt2, Opt3, Opt4, CorrAns)
VALUES
(1, 'Which keyword is used to define a constant in Java?', 'A. var', 'B. let', 'C. final', 'D. const', 'C'),
(2, 'What is the purpose of the "super" keyword in Java?', 'A. Access superclass properties', 'B. Invoke superclass methods', 'C. Define a static variable', 'D. Create an instance of a subclass', 'B'),
(3, 'In Scala, what is the keyword used for defining a class?', 'A. class', 'B. struct', 'C. type', 'D. object', 'A'),
(4, 'Which operator is used for string concatenation in Java?', 'A. +', 'B. &', 'C. ||', 'D. :', 'A'),
(5, 'What is the purpose of the "this" keyword in Java?', 'A. Refer to the current class instance', 'B. Refer to the superclass instance', 'C. Declare a constant', 'D. Define a static method', 'A'),
(6, 'In Scala, what is the purpose of the "val" keyword?', 'A. Define a mutable variable', 'B. Define a constant', 'C. Access a static variable', 'D. Declare a method', 'B'),
(7, 'Which loop is used for iterating over a collection in Java?', 'A. for', 'B. while', 'C. do-while', 'D. foreach', 'A'),
(8, 'What is the default access modifier for members in a Java interface?', 'A. private', 'B. protected', 'C. public', 'D. default', 'C'),
(9, 'In Scala, how is a function defined without parameters?', 'A. def functionName()', 'B. def functionName', 'C. def functionName{}', 'D. def functionName()', 'B'),
(10, 'Which keyword is used to implement multiple inheritance in Scala?', 'A. extends', 'B. implements', 'C. with', 'D. and', 'C');

-- Create table for Information Systems Questions
CREATE TABLE InfoSysQuestions (
    Qno INT PRIMARY KEY,
    Qtext TEXT,
    Opt1 TEXT,
    Opt2 TEXT,
    Opt3 TEXT,
    Opt4 TEXT,
    CorrAns VARCHAR(1)
);

-- Insert Information Systems Questions
INSERT INTO InfoSysQuestions (Qno, Qtext, Opt1, Opt2, Opt3, Opt4, CorrAns)
VALUES
(1, 'What is the primary goal of information systems?', 'A. Cost reduction', 'B. Data storage', 'C. Decision support', 'D. Network security', 'C'),
(2, 'Which type of database model organizes data into tables with rows and columns?', 'A. NoSQL', 'B. Hierarchical', 'C. Relational', 'D. Object-Oriented', 'C'),
(3, 'What does ERP stand for in the context of Information Systems?', 'A. Enterprise Resource Planning', 'B. Efficient Routing Protocol', 'C. Electronic Record Processing', 'D. Exponential Regression Prediction', 'A'),
(4, 'In the context of cybersecurity, what does the term "phishing" refer to?', 'A. Unauthorized access to a system', 'B. Malicious software', 'C. Deceptive attempts to obtain sensitive information', 'D. Network congestion', 'C'),
(5, 'Which programming language is commonly used for developing web-based information systems?', 'A. Java', 'B. C++', 'C. Python', 'D. Ruby', 'A'),
(6, 'What is the purpose of a VPN (Virtual Private Network) in information systems?', 'A. Ensure data integrity', 'B. Secure remote communication over a public network', 'C. Optimize database performance', 'D. Manage user access permissions', 'B'),
(7, 'Which software development methodology emphasizes incremental and iterative development?', 'A. Waterfall', 'B. Agile', 'C. Spiral', 'D. V-Model', 'B'),
(8, 'What is the role of a Business Analyst in the development of information systems?', 'A. Code implementation', 'B. Requirements gathering and analysis', 'C. Database administration', 'D. Quality assurance', 'B'),
(9, 'Which component of an information system is responsible for converting raw data into meaningful information?', 'A. Database Management System (DBMS)', 'B. Central Processing Unit (CPU)', 'C. Input devices', 'D. Output devices', 'A'),
(10, 'What is the purpose of data normalization in database design?', 'A. Increase redundancy', 'B. Improve data integrity', 'C. Decrease data security', 'D. Speed up data retrieval', 'B');
