import 'package:flutter_seesee/pages/add_video/add_video_page.dart';
import 'package:flutter_seesee/pages/friend/friend_page.dart';
import 'package:flutter_seesee/pages/home/home_page.dart';
import 'package:flutter_seesee/pages/login/login_page.dart';
import 'package:flutter_seesee/pages/login/register_page.dart';
import 'package:flutter_seesee/pages/main_page.dart';
import 'package:flutter_seesee/pages/member/member_page.dart';
import 'package:flutter_seesee/pages/member/qrcode_page.dart';
import 'package:flutter_seesee/pages/message/message_page.dart';
import 'package:flutter_seesee/pages/search/search_page.dart';
import 'package:flutter_seesee/pages/settings/settings_page.dart';
import 'package:get/get.dart';

///路由名称
class Routers{

  static const String main = '/main';
  static const String home = '/home';
  static const String friend = '/friend';
  static const String addVideo = '/addVideo';
  static const String message = '/friend';
  static const String member = '/member';
  static const String settings = '/settings';

  static const String search = '/search';
  static const String login = '/login';
  static const String register = '/register';

  static const String qrcode = '/qrcode';

}

///路由管理者
class RouterManager{
  static final routes = [
    GetPage(name: Routers.main, page: () => const MainPage()),
    GetPage(name: Routers.home, page: () => const HomePage()),
    GetPage(name: Routers.friend, page: () => const FriendPage()),
    GetPage(name: Routers.addVideo, page: () => const AddVideoPage()),
    GetPage(name: Routers.message, page: () => const MessagePage()),
    GetPage(name: Routers.member, page: () => MemberPage()),
    GetPage(name: Routers.search, page: () => const SearchPage()),
    GetPage(name: Routers.login, page: () => LoginPage()),
    GetPage(name: Routers.register, page: () => RegisterPage()),
    GetPage(name: Routers.settings, page: () => SettingsPage()),
    GetPage(name: Routers.qrcode, page: () => QrcodePage()),
  ];


}
