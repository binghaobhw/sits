@echo off
set DATASET_NAME=%1
set INPUT=%2
set OUTPUT=%3

java -cp lib/* segmentation.TopicSegmentation --dataset %DATASET_NAME% --input %INPUT% --output %OUTPUT% --burnIn 2500 --maxIter 5000 --sampleLag 100 --gamma 0.25 --model non-param -v --alpha 0.1 --beta 0.1
