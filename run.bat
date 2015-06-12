@echo off
set DATASET_NAME=%1
set INPUT=%2
set OUTPUT=%3

set CLASSPATH=lib\*
java -cp %CLASSPATH% segmentation.TopicSegmentation --dataset %DATASET_NAME% --input %INPUT% --output %OUTPUT% --burnIn 0 --maxIter 10 --sampleLag 1 --gamma 2.5 --model non-param -v --alpha 0.1 --beta 0.1
