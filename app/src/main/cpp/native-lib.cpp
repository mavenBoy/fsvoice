#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_fansen_com_fsvoice_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "hello github";
    return env->NewStringUTF(hello.c_str());
}
