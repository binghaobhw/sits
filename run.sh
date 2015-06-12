DATASET_NAME=$1
INPUT=$2
OUTPUT=$3

CLASSPATH=.
for i in $(\ls lib)
do
    CLASSPATH=${CLASSPATH}:lib/${i}
done

java -cp ${CLASSPATH} segmentation.TopicSegmentation --dataset ${DATASET_NAME} --input ${INPUT} --output ${OUTPUT} --burnIn 0 --maxIter 10 --sampleLag 1 --gamma 2.5 --model non-param -v --alpha 0.1 --beta 0.1
