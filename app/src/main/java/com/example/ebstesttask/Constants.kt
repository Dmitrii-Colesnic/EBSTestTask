package com.example.ebstesttask

object Constants {

    val lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
            "ut labore et dolore magna aliqua. Sed augue lacus viverra vitae congue eu consequat ac. Id volutpat lacus " +
            "laoreet non curabitur gravida arcu. Nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. Tristique " +
            "nulla aliquet enim tortor. Penatibus et magnis dis parturient montes. Tortor at risus viverra adipiscing. " +
            "Praesent tristique magna sit amet purus gravida quis. Non tellus orci ac auctor. Praesent semper feugiat " +
            "nibh sed pulvinar proin gravida. Integer quis auctor elit sed vulputate. Tempor nec feugiat nisl pretium " +
            "fusce id. Diam donec adipiscing tristique risus nec feugiat in fermentum. Sed viverra ipsum nunc aliquet. " +
            "Sit amet porttitor eget dolor morbi non arcu risus quis." +
            "Ac odio tempor orci dapibus. Dui vivamus arcu felis bibendum. In metus vulputate eu " +
            "scelerisque felis imperdiet. Nec nam aliquam sem et tortor. Ipsum dolor sit amet consectetur " +
            "adipiscing elit ut aliquam. Et egestas quis ipsum suspendisse ultrices gravida. Mi proin sed libero " +
            "enim sed faucibus turpis in. Imperdiet massa tincidunt nunc pulvinar sapien. Turpis massa tincidunt " +
            "dui ut ornare lectus sit. Arcu non sodales neque sodales ut etiam sit. Id velit ut tortor pretium "


    val phone1 = MobileEntity(
        image = R.drawable.ic_iphonexc,
        name = "Apple iPhone X",
        characteristic = "iOS,ecran tactil 5.5, GPS, 256 GB, 12mpx",
        price = "980,-",
        information = lorem,
        isChecked = R.drawable.ic_heart,
        isSelected = false
    )

    val HDD = MobileEntity(
        image = R.drawable.ic_hdd,
        name = "Western Digital Caviar Red 4000 GB",
        characteristic = "7000 RPM, SATA 3, 64MB, 3.5",
        price = "980,-",
        information = lorem,
        isChecked = R.drawable.ic_heart,
        isSelected = false

    )

    val phone2 = MobileEntity(
        image = R.drawable.ic_iphone8plus,
        name = "Apple iPhone 8 Plus",
        characteristic = "iOS,ecran tactil 5.5, GPS, 256 GB, 12mpx",
        price = "980,-",
        information = lorem,
        isChecked = R.drawable.ic_heart,
        isSelected = false
    )
}