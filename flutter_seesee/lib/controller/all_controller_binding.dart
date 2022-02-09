
import 'package:flutter_seesee/controller/main_page_controller.dart';
import 'package:get/get.dart';

///所有控制器的加载器，通过Get.lazyPut进行懒注入
class AllControllerBinding implements Bindings {

  @override
  void dependencies() {
    Get.lazyPut<MainPageController>(() => MainPageController());
  }
}