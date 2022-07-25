# TensorFlow Java YOLOv2
This app uses TensorFlow Java API to test the speed of object recognition.
For information on Tensorflow, please have a look at the [official TensorFlow site](https://www.tensorflow.org/install/install_java).
This sample uses YOLOv2 to detect and classify objects.

### Compile and run

**Preconditions:**
- Java JDK 1.8 or greater;
- Maven;
- Download the graph definitions [here](https://drive.google.com/open?id=1GfS1Yle7Xari1tRUEi2EDYedFteAOaoN) and place the files under `src/main/resources/YOLO`
- Compile with `mvn clean package`

**Recommended to install:**
- nVidia CUDA Toolkit 8.0 or higher version;
- nVidia cuDNN GPU accelerated deep learning framework;

## Start

- After compilation, get into `target/`
- Run `java -jar java-yolo.jar <PATH_TO_IMAGE_FILE>`

## Yolo support

The solution doesn't support the YoloV3 model.
