DESCRIPTION = "Tasktracker UI application"
LICENSE = "CLOSED"

SRC_URI = "git://github.com/salmmike/tasktracker-webui.git;branch=master;protocol=https;"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"


RDEPENDS:${PN} += " python3 \
		    python3-flask \
		    python3-requests \
		    python3-waitress "

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "tasktracker-webui.service"

SRC_URI:append = " file://tasktracker-webui.service "
FILES_${PN} += "${systemd_unitdir}/system/tasktracker-webui.service"

do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/tasktracker-webui.service ${D}/${systemd_unitdir}/system
}

inherit setuptools3 systemd


