[![Build 
Status](https://travis-ci.org/cruftlab/random-words.svg?branch=master)](https://travis-ci.org/cruftlab/random-words)
[![codecov](https://codecov.io/gh/cruftlab/random-words/branch/master/graph/badge.svg)](https://codecov.io/gh/cruftlab/random-words)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/8618019dc4c34475a0388646e5d09893)](https://www.codacy.com/app/loket/random-words?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=cruftlab/random-words&amp;utm_campaign=Badge_Grade)
[![Code Climate](https://codeclimate.com/github/cruftlab/random-words/badges/gpa.svg)](https://codeclimate.com/github/cruftlab/random-words)

# Local development
To run the entire application locally, simply issue the following command:
```bash
./mvnw clean spring-boot:run "-Drun.jvmArguments=-Dspring.profiles.active=dev -Dserver.port=8090"
```
