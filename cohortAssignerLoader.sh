#!/bin/bash

iris session iris << __DONE
ZNSPACE "Multimodel"
do \$system.OBJ.ImportDir("/Users/rkuszews/Iris/multimodel-demo/iris-multimodal/src/cls/assigner","*.cls","ck",,1)
halt
__DONE
