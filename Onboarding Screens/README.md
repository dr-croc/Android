1. create a splash screeen 
2. create a  navigation  graph. Resource manager > naigation > + > navigation resouce file > my_nav.xml > []+ add splash screen in the navigation graph
3. add Nav_host_fragment in activity_main.xml 
4. package > on boarding> create a blank fragment[view pager fragment]. > see fragment_view_pager_xml >
5.  create class viewPagerAdapter.kt
6.  go to viewPagerFragment
7.  add fragment view pager in navigation graph and connect it with spalsh screen
8. splash fragment.kt
9.  first_screen.kt[ set the go to second screen]
10.  second_screen.kt[ set the  go to third screen screen]
11.  create a home fragment
12.  connect it in the nav graph
13.  third_screen.kt[set to home fragment] and decalre finish
14.  splash screen and check if on boarding already occured. So that we dont run it again.
15.  Done
