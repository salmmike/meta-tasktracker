DESCRIPTION = "Tasktracker UI application"
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://COPYING;md5=0b517682c7617713822d978dd663ea09"
PATCHTOOL = "git"
SRC_URI = "gitsm://github.com/salmmike/tasktracker.git;branch=master;protocol=https;"
SRCREV = "e0ec97886e0ec1d1f526a86999c292bc2b88f970"

SRC_URI:append = " file://001-remove-clang-tidy.patch "

S = "${WORKDIR}/git"

DEPENDS += " qtbase \
             qtdeclarative \
             qtdeclarative-native \
             qtquick3d \
             qthttpserver \
             sqlite3 \
             gtest \
             fmt "

inherit pkgconfig cmake qt6-cmake
