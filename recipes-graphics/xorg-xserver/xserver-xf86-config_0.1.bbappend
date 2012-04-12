FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
# Don't forget to bump PRINC if you update the extra files.
PRINC = "2"

THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

SRC_URI_append = " file://xorg.conf.d/10-omapfb.conf \
                   file://xorg.conf.d/99-calibration.conf \
"

CONFFILES_${PN} += "${sysconfdir}/X11/xorg.conf.d/10-omapfb.conf \
                    ${sysconfdir}/X11/xorg.conf.d/99-calibration.conf \
"

do_install_append () {
install -d ${D}/${sysconfdir}/X11/xorg.conf.d/
install -m 0644 ${WORKDIR}/xorg.conf.d/* ${D}/${sysconfdir}/X11/xorg.conf.d/
}

FILES_${PN} += "${sysconfdir}/X11/xorg.conf.d"
