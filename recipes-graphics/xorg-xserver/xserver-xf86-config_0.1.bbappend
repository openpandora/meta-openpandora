FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
# Don't forget to bump PRINC if you update the extra files.
PRINC = "3"

THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

SRC_URI_append_omap3-pandora = " file://xorg.conf.d/10-evdev.conf \
                                 file://xorg.conf.d/20-omapfb.conf \
                                 file://xorg.conf.d/99-calibration.conf \
"

CONFFILES_${PN} += "${sysconfdir}/X11/xorg.conf.d/10-evdev.conf \
                    ${sysconfdir}/X11/xorg.conf.d/20-omapfb.conf \
                    ${sysconfdir}/X11/xorg.conf.d/99-calibration.conf \
"

do_install_append () {
        install -d ${D}/${sysconfdir}/X11/xorg.conf.d/
        install -m 0644 ${WORKDIR}/xorg.conf.d/* ${D}/${sysconfdir}/X11/xorg.conf.d/
}

FILES_${PN} += "${sysconfdir}/X11/xorg.conf.d"
